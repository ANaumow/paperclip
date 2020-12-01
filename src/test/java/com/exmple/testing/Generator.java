package com.exmple.testing;

import com.exmple.testing.model.CommentData;
import com.exmple.testing.model.GroupData;
import com.exmple.testing.model.PostData;
import com.exmple.testing.model.Settings;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Collectors;

public class Generator {

    private ObjectMapper objectMapper;

    public static void main(String[] args) throws IOException {
        new Generator().generate();
    }

    private void generate() throws IOException {
        objectMapper = new ObjectMapper();
        Random random = new Random();

        String postStr = String.valueOf(random.nextInt(223131)).chars()
                .mapToObj(operand -> "" + (char) (operand + 'a' - '0'))
                .collect(Collectors.joining());

        String commentStr = String.valueOf(random.nextInt(223131)).chars()
                .mapToObj(operand -> "" + (char) (operand + 'a' - '0'))
                .collect(Collectors.joining());

        PostData post = new PostData("# Heading " + postStr);
        CommentData comment = new CommentData("I think that " + commentStr);
        GroupData group = new GroupData(comment, post);
        String json = objectMapper.writeValueAsString(group);

        File file = new File("test.json");
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(json);
        writer.close();
    }

}
