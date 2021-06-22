package testData;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "credentials")
    public Object[][] getData() {

        Object[][] data = new Object[][]{

                {"jems123", "@yahoo.com"},
                {"jemspeter", "@yahoo.com"},
                {"jpeter", "@yahoo.com"}
        };

        return data;
    }
}
