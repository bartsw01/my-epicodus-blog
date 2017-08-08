package models;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/7/17.
 */
public class PostTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Post.clearAllPosts(); //I clear out allll the posts before each test.
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Post post = new Post("Day 1: Intro");
        assertEquals(true, post instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Post post = new Post("Day 1: Intro");
        assertEquals("Day 1: Intro", post.getContent());
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertTrue(Post.getAll().contains(post));
        assertTrue(Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Post myPost = new Post("Day 1:Intro");
        assertEquals(false, myPost.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception {
        Post myPost = setupNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myPost.getCreatedAt().getDayOfWeek());
    }

    public Post setupNewPost(){
        return new Post("Day 1: Intro");
    }

    @Test
    public   void getId_postsInstantiateWithAnId_1() throws Exception {
        Post.clearAllPosts();
        Post myPost = new Post("Day1: Intro");
        assertEquals(1, myPost.getId());
    }
}