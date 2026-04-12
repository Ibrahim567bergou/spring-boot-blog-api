package com.blog.blogrbac_system.constant;


import org.springframework.http.ResponseEntity;

import java.util.Map;

import static com.blog.blogrbac_system.constant.RequestNameConstant.*;
import static com.blog.blogrbac_system.constant.ResponseObjectConstant.*;
import static com.blog.blogrbac_system.constant.StatusCodeConstant.*;

public class RESPONSE {

    public static ResponseEntity<Object> ADDED_SUCCESS_MESSAGE(){
        return ResponseEntity.ok(
                Map.of(
                    REQUEST_STATUS, STATUS_OK,
                    REQUEST_MESSAGE, RESPONSE_ADD_SUCCESS_MSG
                )
        );
    }

    public static ResponseEntity<Object> DELETED_SUCCESS_MSG(){
        return ResponseEntity.ok(
                Map.of(
                        REQUEST_STATUS, STATUS_OK,
                        REQUEST_MESSAGE, RESPONSE_DELETE_SUCCESS_MSG
                )
        );
    }

    public static ResponseEntity<Object> SUCCESS_MESSAGE(Object data){
        return ResponseEntity.ok(
                Map.of(
                        REQUEST_STATUS, STATUS_OK,
                        REQUEST_DATA, data
                )
        );
    }

    public static ResponseEntity<Object> READ_SUCCESS_NOTIFICATION(){
        return ResponseEntity.ok(
                Map.of(
                        REQUEST_STATUS, STATUS_OK,
                        REQUEST_DATA, RESPONSE_MARK_AS_READ_SUCCESS_MSG
                )
        );
    }
}
