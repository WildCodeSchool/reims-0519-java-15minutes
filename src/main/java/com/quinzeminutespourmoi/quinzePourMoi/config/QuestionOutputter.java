package com.quinzeminutespourmoi.quinzePourMoi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Answer;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Question;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.AnswerRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.QuestionRepository;

@Component
public class QuestionOutputter implements CommandLineRunner{

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public void run(String... args) throws Exception{
        answerRepository.deleteAll();
        questionRepository.deleteAll();

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
             new Question(32L,"Cette peur est-elle encore présente lorsque vous êtes en vol ?"),
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

        Set<Answer> answers = new HashSet<Answer>();
        // alcohol
        answers.add(new Answer(901L,"Tous les jours ou presque", questionRepository.findById(90L).get()));
        answers.add(new Answer(902L,"1 à 3 fois par semaine", questionRepository.findById(90L).get()));
        answers.add(new Answer(903L,"Rarement", questionRepository.findById(90L).get()));
        answers.add(new Answer(911L,"Oui", questionRepository.findById(91L).get()));
        answers.add(new Answer(912L, "Non", questionRepository.findById(91L).get()));
        answers.add(new Answer(921L,"Oui", questionRepository.findById(92L).get()));
        answers.add(new Answer(922L, "Non", questionRepository.findById(92L).get()));
        answers.add(new Answer(931L,"Oui", questionRepository.findById(93L).get()));
        answers.add(new Answer(932L, "Non", questionRepository.findById(93L).get()));
        //animals
        answers.add(new Answer(11L,"Rien qu'en y pensant", questionRepository.findById(1L).get()));
        answers.add(new Answer(12L,"En la voyant", questionRepository.findById(1L).get()));
        answers.add(new Answer(13L,"Au toucher", questionRepository.findById(1L).get()));
        answers.add(new Answer(21L,"Oui", questionRepository.findById(2L).get()));
        answers.add(new Answer(22L,"Non", questionRepository.findById(2L).get()));
        // Spiders/insects
        answers.add(new Answer(111L,"Rien qu'en y pensant", questionRepository.findById(11L).get()));
        answers.add(new Answer(112L,"En la voyant", questionRepository.findById(11L).get()));
        answers.add(new Answer(113L,"Au toucher", questionRepository.findById(11L).get()));
        answers.add(new Answer(121L,"Oui", questionRepository.findById(12L).get()));
        answers.add(new Answer(122L,"Non", questionRepository.findById(12L).get()));
        // cars
        answers.add(new Answer(211L,"Tout le temps", questionRepository.findById(21L).get()));
        answers.add(new Answer(212L,"Souvent", questionRepository.findById(21L).get()));
        answers.add(new Answer(213L,"Rarement", questionRepository.findById(21L).get()));
        answers.add(new Answer(221L,"Oui", questionRepository.findById(22L).get()));
        answers.add(new Answer(222L,"Non", questionRepository.findById(22L).get()));
        answers.add(new Answer(231L,"Plutôt les lignes droites", questionRepository.findById(23L).get()));
        answers.add(new Answer(232L,"Lorsqu'il y a des virages", questionRepository.findById(23L).get()));
        answers.add(new Answer(233L,"Peu importe", questionRepository.findById(23L).get()));
        answers.add(new Answer(241L,"Oui", questionRepository.findById(24L).get()));
        answers.add(new Answer(242L,"Non", questionRepository.findById(24L).get()));
        //plane
        answers.add(new Answer(311L,"Avant d'entrer dans l'avion", questionRepository.findById(31L).get()));
        answers.add(new Answer(312L,"Déjà plusieurs jours avant", questionRepository.findById(31L).get()));
        answers.add(new Answer(321L,"Oui", questionRepository.findById(32L).get()));
        answers.add(new Answer(322L,"Non", questionRepository.findById(32L).get()));
        //foule
        answers.add(new Answer(411L,"Lorsque vous êtes en contact avec la foule", questionRepository.findById(41L).get()));
        answers.add(new Answer(412L,"Dans les transports en commun", questionRepository.findById(41L).get()));
        answers.add(new Answer(413L,"Lorsque vous entrez dans un lieu public", questionRepository.findById(41L).get()));
        answers.add(new Answer(414L,"Lorsque vous êtes dans une rue passante", questionRepository.findById(41L).get()));
        answers.add(new Answer(421L,"Tout le temps", questionRepository.findById(42L).get()));
        answers.add(new Answer(422L,"Souvent", questionRepository.findById(42L).get()));
        answers.add(new Answer(423L,"Rarement", questionRepository.findById(42L).get()));
        //aquaphobie
        answers.add(new Answer(511L,"En voyant l'eau", questionRepository.findById(51L).get()));
        answers.add(new Answer(512L,"Rien qu'en y pensant", questionRepository.findById(51L).get()));
        answers.add(new Answer(521L,"Oui", questionRepository.findById(52L).get()));
        answers.add(new Answer(522L,"Non", questionRepository.findById(52L).get()));
        //claustro
        answers.add(new Answer(611L,"Dans le noir", questionRepository.findById(61L).get()));
        answers.add(new Answer(612L,"Dans un espace clos (ascenceur, pièces sans fenêtre ...)", questionRepository.findById(61L).get()));
        answers.add(new Answer(613L,"Dans un espace restreint", questionRepository.findById(61L).get()));
        answers.add(new Answer(621L,"Tous les jours ou presque", questionRepository.findById(62L).get()));
        answers.add(new Answer(622L,"1 à 3 fois par semaine", questionRepository.findById(62L).get()));
        answers.add(new Answer(623L,"Rarement", questionRepository.findById(62L).get()));
        //alimenaire
        answers.add(new Answer(811L,"Oui", questionRepository.findById(81L).get()));
        answers.add(new Answer(812L,"Non", questionRepository.findById(81L).get()));
        answers.add(new Answer(821L,"Oui", questionRepository.findById(82L).get()));
        answers.add(new Answer(822L,"Non", questionRepository.findById(82L).get()));
        answers.add(new Answer(831L,"Oui", questionRepository.findById(83L).get()));
        answers.add(new Answer(832L,"Non", questionRepository.findById(83L).get()));
        //écrans
        answers.add(new Answer(1011L,"TV", questionRepository.findById(101L).get()));
        answers.add(new Answer(1012L,"Jeux vidéos", questionRepository.findById(101L).get()));
        answers.add(new Answer(1013L,"Smartphones", questionRepository.findById(101L).get()));
        //champs texte à remplir
        answers.add(new Answer(1031L,"Oui", questionRepository.findById(103L).get()));
        answers.add(new Answer(1032L,"Non", questionRepository.findById(103L).get()));
        answers.add(new Answer(1041L,"Oui", questionRepository.findById(104L).get()));
        answers.add(new Answer(1042L,"Oui", questionRepository.findById(104L).get()));
        //cigarettes
        answers.add(new Answer(731L,"Oui", questionRepository.findById(73L).get()));
        answers.add(new Answer(732L,"Non", questionRepository.findById(73L).get()));


        for(Answer answer : answers){
            answerRepository.save(answer);
        }
    }
}
