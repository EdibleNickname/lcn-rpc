package com.can.mq;

import lombok.Data;
import java.io.Serializable;

/**
 * @description: 此处的对象需要和Consumer处的完全一致，既包路径也有一样，否则会序列化失败
 * @author: LCN
 * @date: 2018-11-17 22:09
 */
@Data
public class Demo implements Serializable {
	int num;
	String name;
}
