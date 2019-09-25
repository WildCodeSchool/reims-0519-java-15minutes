package com.quinzeminutespourmoi.quinzePourMoi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Answer;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Question;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.AnswerRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.QuestionRepository;

@Component
public class QuestionOutputter implements CommandLineRunner{

    @Autowired
    private QuestionRepository questionRepository;
    //private AnswerRepository answerRepository;

    public void run(String... args) throws Exception{
        questionRepository.deleteAll();
        //answerRepository.deleteAll();

        Question[] data = new Question []{
            /*phobies*/
            /*animaux*/
            new Question(1L,"Quand cela se manifeste-t'il ?"),
            new Question(2L,"Y a t'il des fois où cette phobie ne se manifeste pas ?"),
            /*araignée/insectes */
            new Question(11L,"Quand cela se manifeste-t'il ?"),
            new Question(12L,"Y a t'il des fois où cette phobie ne se manifeste pas ?"),
            /*voitures*/
            new Question(21L,"A quelle fréquence cela vous arrive-t'il ?"),
            new Question(22L,"Cela dépend t'il de la vitesse ?"),
            new Question(23L,"Sur quel type de route cela vous arrive-t'il ?"),
            new Question(24L,"Y a t'il eu un événement avant la phobie qui aurait pu déclencher votre peur ?"),
            /*avions*/
            new Question(31L,"Quand cela se manifeste-t'il ?"),
            new Question(32L,"Quand cela se manifeste-t'il ?"),
            /*foule*/
            new Question(41L,"Dans quelle situation se manifeste-t'elle ?"),
            new Question(42L,"Quand cela se manifeste-t'il ?"),
            /*aquaphobie*/
            new Question(51L,"Quand cette peur se manifeste-t'elle ?"),
            new Question(52L,"Y a t'il eu un événement qui aurait pu déclencher cette phobie ?"),
            /*claustrophobie*/
            new Question(61L,"Dans quelle situation se manifeste cette peur ?"),
            new Question(62L,"Quand cela se manifeste-t'il ?"),
            
            /*stop à la cigarette */
            new Question(71L,"Depuis combien de temps fumez-vous ?"),
            new Question(72L,"Combien de cigarettes fumez-vous par jours ?"),
            new Question(73L,"Avez-vous déjà essayé d'arrêter ?"),
            new Question(74L,"Si oui, qu'avez-vous fait ?"),

            /*addictions*/
            /*alimentaire*/
            new Question(81L,"La prenez vous pour compenser un stress ?"),
            new Question(82L,"La prenez vous aussi sans aucune raison (automatisme) ?"),
            new Question(83L,"Considérez vous que cette addiction nuit à votre bien être ?"),
                /*alcool*/
            new Question(90L,"A quelle fréquence votre addiction se manifeste-t'elle ?"),
            new Question(91L,"Y a t'il eu un évènement dans votre vie qui aurait pu déclencher cette addiction ?"),
            new Question(92L,"Considérez-vous que cette addiction nuit à votre santé ?"),
            new Question(93L,"Avez-vous le sentiment que cette addiction vous isole ?"),
                /*ecran*/
            new Question(101L,"Quelle est votre addiction ?"),
            new Question(102L,"Depuis combien de temps avez-vous cette addiction ?"),
            new Question(103L,"Avez-vous le sentiment que cette addiction vous isole ?"),
            new Question(104L,"Avez-vous le sentiment que votre addiction s'empire au fil du temps")
        };
        for(Question question : data){
            questionRepository.save(question);
        }

        /*Answer[] data2 = new Answer[]{

            new Answer(1L,"Rien qu'en y pensant"),
            new Answer(2L,"En la voyant"),
            new Answer(3L,"Au toucher"),
            new Answer(4L, "Oui"),
            new Answer(5L, "Non"),
            new Answer()


            };
        for(Answer answer : data2){
            answerRepository.save(answer);
        }*/
    }    
}