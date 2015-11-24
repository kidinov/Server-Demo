package org.kidinov;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @RequestMapping(value = "/getData1", method = RequestMethod.GET, params = "limit")
    @ResponseBody
    public List<Model> getData1(@RequestParam("limit") int limit) {
        return generateData(limit);
    }

    @RequestMapping(value = "/getData2", method = RequestMethod.GET, params = "limit")
    @ResponseBody
    public List<Model> getData2(@RequestParam("limit") int limit) {
        return generateData(limit);
    }

    private List<Model> generateData(int size) {
        List<Model> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            res.add(new Model(generateImageUrl(), generateName()));
        }
        return res;
    }

    private String generateName() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    private String generateImageUrl() {
        return "http://192.168.1.128:8080/" + (Math.random() < 0.33 ? "1.png" : (Math.random() < .66 ? "2.png" : "3.png"));
    }
}
