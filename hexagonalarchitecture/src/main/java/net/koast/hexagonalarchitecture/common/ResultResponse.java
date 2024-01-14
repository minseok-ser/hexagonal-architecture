package net.koast.hexagonalarchitecture.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse<T> {

	private final int status;
  private final T payload;
  private final String message;

  @Builder
  public ResultResponse(int status, T payload, String message) {
    this.status = status;
    this.payload = payload;
    this.message = message;
  }
}
