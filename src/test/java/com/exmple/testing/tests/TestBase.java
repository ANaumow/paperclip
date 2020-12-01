package com.exmple.testing.tests;

import com.exmple.testing.ApplicationManager;
import com.exmple.testing.model.GroupData;
import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.AfterClass;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

public class TestBase {

    protected ApplicationManager app;
    protected GroupData groupData;

    @SneakyThrows
    public TestBase() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.groupData = objectMapper.readValue(new File("test.json"), GroupData.class);
        this.app = ApplicationManager.getInstance();
    }

    @Before
    public void setUp() throws InterruptedException, IOException {
//        this.app.navigation().openSignInPage();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        ApplicationManager.getInstance().stop();
    }

}
