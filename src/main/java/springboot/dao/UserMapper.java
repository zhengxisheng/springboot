package springboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import springboot.domain.User;

@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

	@Insert("insert into user(name,age) values(#{name},#{age})")
	int addUser(@Param("name")String name,@Param("age")String age);
	
	
	@Select("select * from user where id =#{id}")
	@Cacheable(key ="#p0")
	User findById(@Param("id") String id);
}
