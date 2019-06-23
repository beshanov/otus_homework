package com.beshanov.utils;

import com.opencsv.CSVParser;
import com.beshanov.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class QuestionParser {

    @Value("${questions.file}")
    private String fileName;

    @Value("${current.locale}")
    private String currentLocale;

    public ArrayList<Question> getAllQuestions() throws IOException {
        InputStream inputStreamCSV = getClass().getClassLoader().getResourceAsStream(fileName + "_" + currentLocale + ".csv");
        Scanner scanner = new Scanner(inputStreamCSV).useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        String[] questionStrings = result.split("\\n");

        ArrayList<Question> questionList = new ArrayList<Question>();

        try {
            for (String string : questionStrings) {
                Question question = new Question();
                String[] questionFields = new CSVParser(CSVParser.DEFAULT_SEPARATOR).parseLine(string);
                question.setId(Integer.valueOf(questionFields[0].trim()));
                question.setQuestionText(questionFields[1]);
                question.setAnswer(questionFields[2]);
                questionList.add(question);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Invalid format data in CSV file");
        }
        scanner.close();
        inputStreamCSV.close();

        return questionList;
    }
}
