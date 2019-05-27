package com.daishuaiqing.chenhuan.vo;

import com.daishuaiqing.chenhuan.domain.Forum;
import lombok.Data;

@Data
public class ForumDetail {
    private Forum forum;
    private Forum lastForum;
    private Forum nextForum;
}
