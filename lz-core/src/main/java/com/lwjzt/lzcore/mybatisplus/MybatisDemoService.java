package com.lwjzt.lzcore.mybatisplus;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lwjzt.lzcore.domain.McnUser1;
import com.lwjzt.lzcore.domain.User;
import com.lwjzt.lzcore.mapper.McnUser1Mapper;
import com.lwjzt.lzcore.mapper.UserMapper;
import com.lwjzt.lzcore.service.impl.McnUser1ServiceImpl;
import com.lwjzt.lzcore.service.impl.UserServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Data
@Service
@Slf4j
public class MybatisDemoService {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    McnUser1ServiceImpl mcnUser1Service;
    @Autowired
    UserMapper userMapper;
    @Autowired
    McnUser1Mapper mcnUser1Mapper;





    public  void mcnUser() throws IOException {
        List<McnUser1> mcnUser1List=new ArrayList<>();
        BufferedReader reader = FileUtil.getReader("C:\\Users\\oujia\\Desktop\\1.sql", "UTF-8");
        String before="id, name, real_name, sex, address, password, sort_no, cert_name, cert_no, tel, mobtel, fax, email, enable, remark, qq, msn, birthday, login_date, status, user_type, ethnic, home_tel, accounts, workspace, ip, user_id, connect_address, combine_penname, salt, province_city_id, postcode, bank_name, accounts_name, create_date, corr_unit_id";
        String[] split1 = before.split(",");
        boolean flag=true;
        String s = "";
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        while ((s=reader.readLine())!=null){
            if(s.startsWith("values")){
//                System.out.println(s);
                String replace = s.replace("values (", "").replace("'","");
                String[] split = replace.split(",");
                if(split.length==38){
                    McnUser1 mcnUser1 = new McnUser1();
                    mcnUser1.setOrgCode(split[0]);
                    mcnUser1.setPassword("03541495B7E75184C9535DC0DA5C2C89");
                    mcnUser1.setSchemaname("mcntenant_232");
                    mcnUser1.setUserName(split[1]);
                    mcnUser1.setTruename(split[2]);
                    mcnUser1.setSex(Integer.parseInt(split[3].trim()));
                    mcnUser1.setTenantId(232L);
                    mcnUser1.setUnit(split[25]);
                    mcnUser1.setStatus(Integer.parseInt(split[13].trim()));
                    mcnUser1.setUserType(0);
                    mcnUser1.setMobile(split[10]);
                    mcnUser1.setEmail(split[12]);
                    mcnUser1.setIdNumber(split[8]);
                    mcnUser1.setIsDeleted(0);
                    mcnUser1.setUserType(0);
                    mcnUser1.setAddress(split[28]);
                    if(!objectObjectHashMap.containsKey(mcnUser1.getUserName())){
                        mcnUser1List.add(mcnUser1);
                        objectObjectHashMap.put(mcnUser1.getUserName(),mcnUser1.getUserName());
                    }

                }else if (split.length==37) {
                    McnUser1 mcnUser1 = new McnUser1();
                    mcnUser1.setPassword("03541495B7E75184C9535DC0DA5C2C89");
                    mcnUser1.setSchemaname("mcntenant_232");
                    mcnUser1.setUserName(split[1]);
                    mcnUser1.setTruename(split[2]);
                    mcnUser1.setSex(Integer.parseInt(split[3].trim()));
                    mcnUser1.setOrgCode(split[0]);
                    mcnUser1.setTenantId(232L);
                    mcnUser1.setUnit(split[24]);
                    mcnUser1.setStatus(Integer.parseInt(split[13].trim()));
                    mcnUser1.setUserType(0);
                    mcnUser1.setMobile(split[10]);
                    mcnUser1.setEmail(split[12]);
                    mcnUser1.setIdNumber(split[8]);
                    mcnUser1.setIsDeleted(0);
                    mcnUser1.setUserType(0);
                    mcnUser1.setAddress(split[27]);
                    if(!objectObjectHashMap.containsKey(mcnUser1.getUserName())){
                        mcnUser1List.add(mcnUser1);
                        objectObjectHashMap.put(mcnUser1.getUserName(),mcnUser1.getUserName());
                    }

                }else if(split.length==39){
                    McnUser1 mcnUser1 = new McnUser1();
                    mcnUser1.setOrgCode(split[0]);
                    mcnUser1.setSchemaname("mcntenant_232");
                    mcnUser1.setPassword("03541495B7E75184C9535DC0DA5C2C89");
                    mcnUser1.setUserName(split[1]);
                    mcnUser1.setTruename(split[2]);
                    mcnUser1.setSex(Integer.parseInt(split[3].trim()));
                    mcnUser1.setTenantId(232L);
                    mcnUser1.setUnit(split[24]);
                    mcnUser1.setStatus(Integer.parseInt(split[13].trim()));
                    mcnUser1.setUserType(0);
                    mcnUser1.setMobile(split[10]);
                    mcnUser1.setEmail(split[12]);
                    mcnUser1.setIdNumber(split[8]);
                    mcnUser1.setIsDeleted(0);
                    mcnUser1.setUserType(0);
                    mcnUser1.setAddress(split[27]);
                    if(!objectObjectHashMap.containsKey(mcnUser1.getUserName())){
                        mcnUser1List.add(mcnUser1);
                        objectObjectHashMap.put(mcnUser1.getUserName(),mcnUser1.getUserName());
                    }

                }else {
                    McnUser1 mcnUser1 = new McnUser1();
                    mcnUser1.setOrgCode(split[0]);
                    mcnUser1.setSchemaname("mcntenant_232");
                    mcnUser1.setPassword("03541495B7E75184C9535DC0DA5C2C89");
                    mcnUser1.setUserName(split[1]);
                    mcnUser1.setTruename(split[2]);
                    mcnUser1.setSex(Integer.parseInt(split[3].trim()));
                    mcnUser1.setTenantId(232L);
                    mcnUser1.setUnit(split[26]);
                    mcnUser1.setStatus(Integer.parseInt(split[13].trim()));
                    mcnUser1.setUserType(0);
                    mcnUser1.setMobile(split[10]);
                    mcnUser1.setEmail(split[12]);
                    mcnUser1.setIdNumber(split[8]);
                    mcnUser1.setIsDeleted(0);
                    mcnUser1.setUserType(0);
                    mcnUser1.setAddress(split[29]);
                    if(!objectObjectHashMap.containsKey(mcnUser1.getUserName())){
                        mcnUser1List.add(mcnUser1);
                        objectObjectHashMap.put(mcnUser1.getUserName(),mcnUser1.getUserName());
                    }

                }
            }else if(flag&&s.startsWith("insert")){
                before=s;
                flag=false;
            }
        }
        System.out.println(mcnUser1List.size());
        mcnUser1Service.saveBatch(mcnUser1List);
    }

}
