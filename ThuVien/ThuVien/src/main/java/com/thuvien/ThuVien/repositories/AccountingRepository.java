package com.thuvien.ThuVien.repositories;

import com.thuvien.ThuVien.entitys.Accountings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends JpaRepository<Accountings, Long> {
}
