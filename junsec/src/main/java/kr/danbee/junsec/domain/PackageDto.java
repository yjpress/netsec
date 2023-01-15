package kr.danbee.junsec.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageDto {
    boolean isNew;

    public boolean getIsNew() {
        return this.isNew;
    }
}