package com.pb.blog.StudentController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pb.blog.StudentDetails.DataRequest;
import com.pb.blog.StudentDetails.DataResponse;

@RestController
@RequestMapping("/bfhl")
public class StudentController 
{
	    @PostMapping
	    public ResponseEntity<DataResponse> handlePostRequest(@RequestBody DataRequest dataRequest) {
	        DataResponse response = new DataResponse();
	        
	        // Example User Data
	        String fullName = "john_doe";
	        String dob = "17091999";
	        response.setUser_id(fullName + "_" + dob);
	        response.setEmail("john@xyz.com");
	        response.setRoll_number("ABCD123");
	        
	        // Separate numbers and alphabets
	        List<String> numbers = new ArrayList<>();
	        List<String> alphabets = new ArrayList<>();
	        List<String> highestLowerCaseAlphabet = new ArrayList<>();

	        char highestChar = 'a' - 1;  // Start below 'a'

	        for (String item : dataRequest.getData()) {
	            if (item.matches("\\d+")) {  // If item is a number
	                numbers.add(item);
	            } else if (item.matches("[a-zA-Z]")) {  // If item is a letter
	                alphabets.add(item);
	                // Check if it's a lowercase letter and track the highest
	                if (item.matches("[a-z]") && item.charAt(0) > highestChar) {
	                    highestChar = item.charAt(0);
	                }
	            }
	        }

	        if (highestChar >= 'a') {
	            highestLowerCaseAlphabet.add(String.valueOf(highestChar));
	        }

	        // Set response data
	        response.setIs_success(true);
	        response.setNumbers(numbers);
	        response.setAlphabets(alphabets);
	        response.setHighest_lowercase_alphabet(highestLowerCaseAlphabet);

	        return ResponseEntity.ok(response);
	    }

	    @GetMapping
	    public ResponseEntity<Map<String, Integer>> handleGetRequest() {
	        Map<String, Integer> response = new HashMap<>();
	        response.put("operation_code", 1);
	        return ResponseEntity.ok(response);
	    }
}
