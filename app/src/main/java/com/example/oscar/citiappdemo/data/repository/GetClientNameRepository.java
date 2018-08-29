package com.example.oscar.citiappdemo.data.repository;

import com.example.oscar.citiappdemo.data.remote.RestServiceFactory;
import com.example.oscar.citiappdemo.data.remote.endpoints.GetClientNameService;
import com.example.oscar.citiappdemo.data.remote.models.GetClientNameRequest;
import com.example.oscar.citiappdemo.data.remote.models.GetClientNameResponse;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link GetClientNameRepository} for retrieving user data.
 */
@Singleton
public class GetClientNameRepository implements GetClientNameDataRepository {

    private final static String endpoint = "https://uat.mobile.citibanamex.com/c735_015_middlewarep4/";

    @Override
    public Observable<GetClientNameResponse> getClientName(GetClientNameRequest request) {
        //for this case we always get all data from the cloud
        GetClientNameService getClientNameService = RestServiceFactory
                .createRetrofitService(GetClientNameService.class, endpoint);

        Map<String,String> fields = new HashMap<>();
        fields.put("clientNumber", "123456");
        fields.put("vRelease", "R4");
        fields.put("RSA_mobileSDK", "{\n" +
                "                \"TIMESTAMP\": \"2018-08-29T03:15:52Z\",\n" +
                "                \"HardwareID\": \"-1\",\n" +
                "                \"SIM_ID\": \"-1\",\n" +
                "                \"PhoneNumber\": \"-1\",\n" +
                "                \"RSA_ApplicationKey\": \"A2937926E3FF9BE4E6FC939C9AF5406D\",\n" +
                "                \"SDK_VERSION\": \"3.5.0\",\n" +
                "                \"Compromised\": 0,\n" +
                "                \"Emulator\": 0\n" +
                "    }");
        fields.put("appID", "CitiBanamex");
        fields.put("appver", "18.0.0");
        fields.put("channel", "rc");
        fields.put("lang", "2");
        fields.put("mobileIpAddress", "10.0.0.9");
        fields.put("platform", "Android");
        fields.put("platformver", "18.0.0");
        fields.put("serviceID", "getClientName");
        return getClientNameService.getClientNameService(fields);
    }
}