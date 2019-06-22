package utils;

import com.opencsv.CSVParser;
import domain.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionParser {
    private String fileName;

    public QuestionParser(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Question> getAllQuestions() throws IOException {
        InputStream inputStreamCSV = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStreamCSV).useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        String[] questionStrings = result.split("\\n");

        ArrayList<Question> questionList = new ArrayList<Question>();

        for (String string : questionStrings) {
            Question question = new Question();
            String[] questionFields = new CSVParser(CSVParser.DEFAULT_SEPARATOR).parseLine(string);
            question.setId(Integer.valueOf(questionFields[0].trim()));
            question.setQuestionText(questionFields[1]);
            question.setAnswer(questionFields[2]);
            questionList.add(question);
        }
        scanner.close();
        inputStreamCSV.close();

        return questionList;
    }
}
