package com.ui.demo.service;

import com.ui.demo.requestdto.RequestDTO;
import com.ui.demo.responsedto.ResponseDTO;

public interface UserService
{
  ResponseDTO registeruser(RequestDTO requestDTO);

}
