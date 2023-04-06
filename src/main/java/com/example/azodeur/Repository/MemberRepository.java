package com.example.azodeur.Repository;

import com.example.azodeur.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    public Member findByAzodeurId(String azodeurId);

    public boolean existsByAzodeurId(String azodeurId);

//    public boolean existsByAddressIsNull(String azodeurId);
}