package com.kish.jpa.tutorial;

import com.kish.jpa.tutorial.dao.onetomany.model.Company;
import com.kish.jpa.tutorial.dao.onetomany.model.Product;
import com.kish.jpa.tutorial.dao.onetomany.service.CompanyRepoService;
import com.kish.jpa.tutorial.dao.onetomany.service.ProductRepoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;


@Slf4j
@SpringBootApplication
public class JpaonetomanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaonetomanyApplication.class, args);
    }


    @Component
    @Profile("onetomany")
    class JpaApplicationRunner implements ApplicationRunner{

        private final CompanyRepoService companyRepoService;
        private final ProductRepoService productRepoService;

        JpaApplicationRunner(CompanyRepoService companyRepoService, ProductRepoService productRepoService) {
            this.companyRepoService = companyRepoService;
            this.productRepoService = productRepoService;
        }



        @Override
        public void run(ApplicationArguments args) throws Exception {
//            saveDataWithApproach1();
            saveDataWithApproach2();

            showData();

        }

        @Transactional
         void showData(){
            // get All data
            List<Company> companyLst = companyRepoService.findAll();
            List<Product> productLst = productRepoService.findAll();

            System.out.println("===================Product List:==================");
            productLst.forEach(System.out::println);

            System.out.println("===================Company List:==================");
            companyLst.forEach(System.out::println);
        }

        @Transactional
         void saveDataWithApproach1(){
            Company apple = new Company("Apple");
            Company samsung = new Company("Samsung");

            Product iphone7 = new Product("Iphone 7", apple);
            Product iPadPro = new Product("IPadPro", apple);

            Product galaxyJ7 = new Product("GalaxyJ7", samsung);
            Product galaxyTabA = new Product("GalaxyTabA", samsung);

            apple.setProducts(new HashSet<Product>(){{
                add(iphone7);
                add(iPadPro);
            }});

            samsung.setProducts(new HashSet<Product>(){{
                add(galaxyJ7);
                add(galaxyTabA);
            }});

            // save companies
            companyRepoService.save(apple);
            companyRepoService.save(samsung);
        }

        @Transactional
         void saveDataWithApproach2(){

            /*
             * Firstly persist companies (not include product list)
             */
            Company apple = new Company("Apple");
            Company samsung = new Company("Samsung");

            //save companies
            companyRepoService.save(apple);
            companyRepoService.save(samsung);

            /*
             * Then store products with had persisted companies.
             */
            Product iphone7 = new Product("Iphone 7", apple);
            Product iPadPro = new Product("IPadPro", apple);

            Product galaxyJ7 = new Product("GalaxyJ7", samsung);
            Product galaxyTabA = new Product("GalaxyTabA", samsung);

            // save products
            productRepoService.save(iphone7);
            productRepoService.save(iPadPro);

            productRepoService.save(galaxyJ7);
            productRepoService.save(galaxyTabA);
        }
    }
}
