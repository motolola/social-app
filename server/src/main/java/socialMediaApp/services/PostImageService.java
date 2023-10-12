package socialMediaApp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import socialMediaApp.mappers.PostImageMapper;
import socialMediaApp.models.Post;
import socialMediaApp.models.PostImage;
import socialMediaApp.repositories.PostImageRepository;
import socialMediaApp.repositories.PostRepository;
import socialMediaApp.responses.postImage.PostImageResponse;
import socialMediaApp.utils.ImageUtil;

import java.util.Collections;
import java.util.Optional;

@Service
@Slf4j
public class PostImageService {

    private final PostImageRepository postImageRepository;

    private final PostRepository postRepository;
    private final PostService postService;
    private final PostImageMapper postImageMapper;

    public PostImageService(PostImageRepository postImageRepository, PostRepository postRepository, PostService postService, PostImageMapper postImageMapper) {
        this.postImageRepository = postImageRepository;
        this.postRepository = postRepository;
        this.postService = postService;
        this.postImageMapper = postImageMapper;
    }

    public PostImageResponse upload(MultipartFile file, int postId)  {
        try {
            PostImage postImage = new PostImage();
            postImage.setName(file.getOriginalFilename());
            postImage.setType(file.getContentType());
            postImage.setData(ImageUtil.compressImage(file.getBytes()));
            Post post = postService.getById(postId);
            postImage.setPost(post);
            post.setPostImages(Collections.singleton(postImage));
            postRepository.save(post);
            return postImageMapper.imageToResponse(postImage);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error saving post image", e);

        }
        return null;
    }

    public byte[] download(int id){
        Optional<PostImage> postImage = postImageRepository.findPostImageByPost_Id(id);
        if (postImage.isPresent()){
            return ImageUtil.decompressImage(postImage.get().getData());
        }
        return null;
    }
}
