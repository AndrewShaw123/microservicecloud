package com.andrew.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Dept Class
 *
 * @author andrew
 * @date 2020/5/14
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String db_source;


}
