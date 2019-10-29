package org.smartframework.cloud.starter.common.business.util.exception;

import org.smartframework.cloud.common.pojo.dto.RespHead;
import org.smartframework.cloud.common.pojo.enums.ReturnCodeEnum;
import org.smartframework.cloud.starter.common.business.util.RespHeadUtil;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @desc 上传文件大小超过限制异常转换
 * @author liyulin
 * @date 2019/10/29
 */
public class MaxUploadSizeExceededExceptionHandlerStrategy implements IExceptionHandlerStrategy {

	@Override
	public boolean match(Throwable e) {
		return e instanceof MaxUploadSizeExceededException;
	}

	@Override
	public RespHead transRespHead(Throwable e) {
		return RespHeadUtil.of(ReturnCodeEnum.UPLOAD_FILE_SIZE_EXCEEDED, e.getMessage());
	}
	
}