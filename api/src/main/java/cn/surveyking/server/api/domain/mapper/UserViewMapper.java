package cn.surveyking.server.api.domain.mapper;

import cn.surveyking.server.api.domain.dto.UserView;
import cn.surveyking.server.core.uitls.SpringContextHolder;
import cn.surveyking.server.api.domain.model.User;
import cn.surveyking.server.api.mapper.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author javahuang
 * @date 2021/8/24
 */
@Mapper(componentModel = "spring")
public interface UserViewMapper {

	UserView toUserView(User user);

	List<UserView> toUserView(List<User> users);

	default UserView toUserViewById(String id) {
		if (id == null) {
			return null;
		}
		UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
		return toUserView(userMapper.selectById(id));
	}

}
