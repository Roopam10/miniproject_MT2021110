package com.iiitb.roopam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    private static final Logger logger = LogManager.getLogger("calculatorController");
    @RequestMapping(value="/getSqrt", method=RequestMethod.POST)
    public double getSquareRoot(@RequestBody Map<String, String> val) {
        double input1 = Double.parseDouble(val.get("input1"));

        double res = Math.sqrt(input1);
        logger.info("[Square Root] - INPUT = " + input1 + "OUTPUT = " + res);

        return res;
    }

    @RequestMapping(value="/getFact", method=RequestMethod.POST)
    public double getFact(@RequestBody Map<String, String> val) {
        double input1 = Double.parseDouble(val.get("input1"));

        double res = 1;

        for(double i = input1; i > 1; i--) {
            res *= i;
        }

        logger.info("[Factorial] - INPUT = " + input1 + "OUTPUT = " + res);

        return res;
    }

    @RequestMapping(value="/getPow", method=RequestMethod.POST)
    public double getPow(@RequestBody Map<String, String> val) {
        double input1 = Double.parseDouble(val.get("input1"));
        double input2 = Double.parseDouble(val.get("input2"));

        double res = Math.pow(input1, input2);

        logger.info("[Power] - INPUT1 = " + input1 + "INPUT2" + input2 + "OUTPUT = " + res);

        return res;
    }

    @RequestMapping(value="/getLog", method=RequestMethod.POST)
    public double getLog(@RequestBody Map<String, String> val) {
        double input1 = Double.parseDouble(val.get("input1"));

        double res = Math.log10(input1);

        logger.info("[Logarithm] - INPUT = " + input1 + "OUTPUT = " + res);

        return res;
    }
}