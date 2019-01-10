package nbp.api;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import nbp.api.rest.NBPapi;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(JUnitParamsRunner.class)
public class NBPapiTest {

    NBPapi nbpApi;

    @Test
    @Parameters(method = "getJSONRequestResponse")
    public void getJSONfromNBPapiTest(String request, String expectedResponse){
        nbpApi.get();

        MatcherAssert.assertThat(request,is(equalTo(expectedResponse)));
    }

    public Object[] getJSONRequestResponse(){
return new Object[]{
        new Object[]{},
        new Object[]{}
        };
    }
}