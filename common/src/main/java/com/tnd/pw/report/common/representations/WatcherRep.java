package com.tnd.pw.report.common.representations;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WatcherRep  implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private Long id;
    @SerializedName("belong_id")
    private Long objectId;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("user")
    private String user;
}