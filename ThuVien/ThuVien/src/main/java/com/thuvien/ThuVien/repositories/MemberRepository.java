package com.thuvien.ThuVien.repositories;

import com.thuvien.ThuVien.entitys.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Members, Long> {
}
