package com.kish.jpa.tutorial;


import com.kish.jpa.tutorial.dao.onetoone.model.Husband;
import com.kish.jpa.tutorial.dao.onetoone.model.Wife;
import com.kish.jpa.tutorial.dao.onetoone.service.HusbandRepoService;
import com.kish.jpa.tutorial.dao.onetoone.service.WifeRepoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaonetooneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaonetooneApplication.class,args);
    }


    @Component
    @Profile("onetoone")
    class OnetoOneApplicationRunner implements ApplicationRunner{

        private final WifeRepoService wifeRepository;
        private final HusbandRepoService husbandRepository;

        public OnetoOneApplicationRunner(WifeRepoService wifeRepository, HusbandRepoService husbandRepository) {
            this.wifeRepository = wifeRepository;
            this.husbandRepository = husbandRepository;
        }


        @Transactional
        void deleteData(){
            wifeRepository.deleteAll();
            husbandRepository.deleteAll();
        }

        @Transactional
        void saveData(){
            // Store a wife to DB
            Wife lisa = new Wife("Lisa", new Husband("David"));
            wifeRepository.save(lisa);

            // Store list wifes to DB
            Wife mary = new Wife("Mary", new Husband("Peter"));
            Wife lauren = new Wife("Lauren", new Husband("Phillip"));

            wifeRepository.saveAll(Arrays.asList(mary, lauren));
        }

        @Transactional
        void showData(){
            // get All data
            List<Wife> wifes = wifeRepository.findAll();
            List<Husband> husbands = husbandRepository.findAll();

            System.out.println("===================Wifes:==================");
            wifes.forEach(System.out::println);

            System.out.println("===================Husbands:==================");
            husbands.forEach(System.out::println);
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
            saveData();
            showData();
        }
    }
}
