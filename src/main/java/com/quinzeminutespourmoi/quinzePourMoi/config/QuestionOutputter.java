package com.quinzeminutespourmoi.quinzePourMoi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Question;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.QuestionRepository;

@Component
public class QuestionOutputter implements CommandLineRunner{

    @Autowired
    private QuestionRepository questionRepository;

    public void run(String... args) throws Exception{
        questionRepository.deleteAll();

        Question[] data = new Question []{
            /*phobies*/
            /*animaux*/
            new Question("Quand cela se manifeste-t'il ?"),
            new Question("Y a t'il des fois où cette phobie ne se manifeste pas ?"),
            /*araignée/insectes */
            new Question("Quand cela se manifeste-t'il ?"),
            new Question("Y a t'il des fois où cette phobie ne se manifeste pas ?"),
            /*voitures*/
            new Question("A quelle fréquence cela vous arrive-t'il ?"),
            new Question("Cela dépend t'il de la vitesse ?"),
            new Question("Sur quel type de route cela vous arrive-t'il ?"),
            new Question("Y a t'il eu un événement avant la phobie qui aurait pu déclencher votre peur ?"),
            /*avions*/
            new Question("Quand cela se manifeste-t'il ?"),
            new Question("Quand cela se manifeste-t'il ?"),
            /*foule*/
            new Question("Dans quelle situation se manifeste-t'elle ?"),
            new Question("Quand cela se manifeste-t'il ?"),
            /*aquaphobie*/
            new Question("Quand cette peur se manifeste-t'elle ?"),
            new Question("Y a t'il eu un événement qui aurait pu déclencher cette phobie ?"),
            /*claustrophobie*/
            new Question("Dans quelle situation se manifeste cette peur ?"),
            new Question("Quand cela se manifeste-t'il ?"),
            
            /*stop à la cigarette */
            new Question("Depuis combien de temps fumez-vous ?"),
            new Question("Combien de cigarettes fumez-vous par jours ?"),
            new Question("Avez-vous déjà essayé d'arrêter ?"),
            new Question("Si oui, qu'avez-vous fait ?"),

            /*addictions*/
            /*alimentaire*/
            new Question("La prenez vous pour compenser un stress ?"),
            new Question("La prenez vous aussi sans aucune raison (automatisme) ?"),
            new Question("Considérez vous que cette addiction nuit à votre bien être ?"),
                /*alcool*/
            new Question("A quelle fréquence votre addiction se manifeste-t'elle ?"),
            new Question("Y a t'il eu un évènement dans votre vie qui aurait pu déclencher cette addiction ?"),
            new Question("Considérez-vous que cette addiction nuit à votre santé ?"),
            new Question("Avez-vous le sentiment que cette addiction vous isole ?"),
                /*ecran*/
            new Question("Quelle est votre addiction ?"),
            new Question("Depuis combien de temps avez-vous cette addiction ?"),
            new Question("Avez-vous le sentiment que cette addiction vous isole ?"),
            new Question("Avez-vous le sentiment que votre addiction s'empire au fil du temps")
        };
        for(Question question : data){
            questionRepository.save(question);
        }      
    }
}