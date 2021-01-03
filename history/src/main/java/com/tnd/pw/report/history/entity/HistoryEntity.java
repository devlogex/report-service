package com.tnd.pw.report.history.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class HistoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private Long id;
    @SerializedName("updated_at")
    private Long updatedAt;
    @SerializedName("updated_by")
    private Long updatedBy;
    @SerializedName("action")
    private String action;
    @SerializedName("object_id")
    private Long objectId;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("content")
    private String content;
}
