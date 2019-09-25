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
            new Question(1L,"Quand cela se manifeste-t'il ?"),
            new Question(2L,"Y a t'il des fois où cette phobie ne se manifeste pas ?"),
            /*araignée/insectes */
            new Question(3L,"Quand cela se manifeste-t'il ?"),
            new Question(4L,"Y a t'il des fois où cette phobie ne se manifeste pas ?"),
            /*voitures*/
            new Question(5L,"A quelle fréquence cela vous arrive-t'il ?"),
            new Question(6L,"Cela dépend t'il de la vitesse ?"),
            new Question(7L,"Sur quel type de route cela vous arrive-t'il ?"),
            new Question(8L,"Y a t'il eu un événement avant la phobie qui aurait pu déclencher votre peur ?"),
            /*avions*/
            new Question(9L,"Quand cela se manifeste-t'il ?"),
            new Question(10L,"Quand cela se manifeste-t'il ?"),
            /*foule*/
            new Question(11L,"Dans quelle situation se manifeste-t'elle ?"),
            new Question(12L,"Quand cela se manifeste-t'il ?"),
            /*aquaphobie*/
            new Question(13L,"Quand cette peur se manifeste-t'elle ?"),
            new Question(14L,"Y a t'il eu un événement qui aurait pu déclencher cette phobie ?"),
            /*claustrophobie*/
            new Question(15L,"Dans quelle situation se manifeste cette peur ?"),
            new Question(16L,"Quand cela se manifeste-t'il ?"),
            
            /*stop à la cigarette */
            new Question(17L,"Depuis combien de temps fumez-vous ?"),
            new Question(18L,"Combien de cigarettes fumez-vous par jours ?"),
            new Question(19L,"Avez-vous déjà essayé d'arrêter ?"),
            new Question(20L,"Si oui, qu'avez-vous fait ?"),

            /*addictions*/
            /*alimentaire*/
            new Question(21L,"La prenez vous pour compenser un stress ?"),
            new Question(22L,"La prenez vous aussi sans aucune raison (automatisme) ?"),
            new Question(23L,"Considérez vous que cette addiction nuit à votre bien être ?"),
                /*alcool*/
            new Question(24L,"A quelle fréquence votre addiction se manifeste-t'elle ?"),
            new Question(25L,"Y a t'il eu un évènement dans votre vie qui aurait pu déclencher cette addiction ?"),
            new Question(26L,"Considérez-vous que cette addiction nuit à votre santé ?"),
            new Question(27L,"Avez-vous le sentiment que cette addiction vous isole ?"),
                /*ecran*/
            new Question(28L,"Quelle est votre addiction ?"),
            new Question(29L,"Depuis combien de temps avez-vous cette addiction ?"),
            new Question(30L,"Avez-vous le sentiment que cette addiction vous isole ?"),
            new Question(31L,"Avez-vous le sentiment que votre addiction s'empire au fil du temps")
        };
        for(Question question : data){
            questionRepository.save(question);
        }      
    }
}