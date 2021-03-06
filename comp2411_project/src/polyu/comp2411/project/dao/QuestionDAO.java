package polyu.comp2411.project.dao;

import polyu.comp2411.project.entity.Exam;
import polyu.comp2411.project.entity.Question;

import java.util.List;

public interface QuestionDAO {
    Question searchByID(int id);
    void addQuestion(Question que);
    void delQuestion(Question que);
    List<Question> searchByExam(Exam ex);
}
