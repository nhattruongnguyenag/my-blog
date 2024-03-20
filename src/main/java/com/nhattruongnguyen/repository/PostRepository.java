package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    PostEntity findBySlug(String slug);

    @Query(value = "select p2.* from categories_posts cp1" +
            "\n join categories_posts cp2 on cp1.category_id = cp2.category_id" +
            "\n join posts p1 on cp1.post_id = p1.id" +
            "\n join posts p2 on cp2.post_id = p2.id" +
            "\n where p1.slug <> p2.slug and p1.slug = :postSlug" +
            "\n group by p1.slug, p2.slug" +
            "\n order by p2.id desc limit 5", nativeQuery = true)
    List<PostEntity> findRelatedPost(@Param("postSlug") String postSlug);
    PostEntity findOneById(Long id);

    @Query(value = "SELECT p FROM PostEntity p JOIN p.postTrash ORDER BY p.updatedAt DESC", countQuery = "SELECT count(p) FROM PostEntity p JOIN p.postTrash")
    Page<PostEntity> findPostsInTrashWithPagination(Pageable pageable);
}
