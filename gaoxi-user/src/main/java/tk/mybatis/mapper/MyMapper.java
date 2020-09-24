package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName MyMapper
 * @Author luyingshan 卢
 * @Date 2020/9/22
 * @Version 1.0
 */
public interface MyMapper<T>  extends Mapper<T>, MySqlMapper<T> {
}
