package com.example.jpa.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.CrudRepository;
@Mapper
public interface Usermapper extends CrudRepository<MUser,Integer> {

    public MUser findByUsername(String username);
    public MUser findByUsernameAndPassword(String username,String password);
}
