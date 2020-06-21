package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.MessageDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select new com.example.sweater.domain.dto.MessageDto("+
            "m, "+
            " count(ml), " +
            " sum(case when ml = :user then 1 else 0 end) > 0" +
            ")" +
            "from Message m left join m.likes ml " +
            "group by m")
    List<MessageDto> findAll(@Param("user") User user);
    @Query("select new com.example.sweater.domain.dto.MessageDto("+
            "m, "+
            " count(ml), " +
            " sum(case when ml = :user then 1 else 0 end) > 0" +
            ")" +
            "from Message m left join m.likes ml " +
            "where m.tag = :tag " +
            "group by m")
    List<MessageDto> findByTag(String tag, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.author = :author " +
            "group by m")
    Set<MessageDto> findByUser(@Param("author") User author, @Param("user") User user);
}
