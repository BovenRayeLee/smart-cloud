package org.smartframework.cloud.starter.common.business.util.exception;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.smartframework.cloud.common.pojo.dto.RespHead;
import org.smartframework.cloud.common.pojo.enums.ReturnCodeEnum;
import org.smartframework.cloud.starter.common.business.util.ExceptionUtil;
import org.smartframework.cloud.starter.common.business.util.RespHeadUtil;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * @desc 方法参数不合法异常转换
 * @author liyulin
 * @date 2019/10/29
 */
public class MethodArgumentNotValidExceptionHandlerStrategy implements IExceptionHandlerStrategy {

	@Override
	public boolean match(Throwable e) {
		return e instanceof MethodArgumentNotValidException;
	}

	@Override
	public RespHead transRespHead(Throwable e) {
		// 参数校验
		List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
		if (CollectionUtils.isNotEmpty(fieldErrors)) {
			String errorMsg = ExceptionUtil.getErrorMsg(fieldErrors);
			return RespHeadUtil.of(ReturnCodeEnum.VALIDATE_FAIL, errorMsg);
		}
		return RespHeadUtil.of(ReturnCodeEnum.VALIDATE_FAIL, e.getMessage());
	}

}