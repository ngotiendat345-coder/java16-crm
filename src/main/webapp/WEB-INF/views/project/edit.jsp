<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Task</title>
</head>
<body>
<!-- Breadcrumb -->
<div class="container page__heading-container">
	<div class="page__heading">
		<div class="d-flex align-items-center">
			<div>
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0">
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">
							Task</li>
					</ol>
				</nav>
				<h1 class="m-0">Task Manager</h1>
			</div>
			<div class="ml-auto">
				<a href="" class="btn btn-light"><i
					class="material-icons icon-16pt text-muted mr-1">settings</i>
					Settings</a>
			</div>
		</div>
	</div>
</div>
<!-- End Breadcrumb -->
<!-- BEGIN PAGE HEADER-->

<div class="container page__heading-container">
	<div class="page__heading">
		<div>
			<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title text-center">
			<span>Chỉnh sửa ĐẦU VIỆC</span>
		</h3>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<br>
<!-- END PAGE HEADER-->
<!-- BEGIN ADVANCED TABLE widget-->
<div class="row-fluid">
	<div class="span2"></div>
	<div class="span8">
		<!-- BEGIN EXAMPLE TABLE widget-->
		<div class="widget orange">
			<div class="widget-title">
				<h4>
					<i class="icon-list-ul"></i> Thêm đầu việc
				</h4>
				<span class="tools"> <a href="javascript:;"
					class="icon-chevron-down"></a> <a href="javascript:;"
					class="icon-remove"></a>
				</span>
			</div>
			<div class="widget-body">
				<p class="text-center" style="color:red;">${ message }</p>
				<form action='<c:url value="/project/edit"/>' method="post">
					<div class="row-fluid">
						<div class="span12s">
						<input type="text" class="form-control" id="id"
								value="${ task.id }" readonly hidden="true"
								name="id">
							<div class="control-group">
								<label class="control-label">Tên công việc</label>
								<div class="controls">
									<input type="text" value="${task.name }" class="span12" id="name" name="name">
								</div>
							</div>
							
							
							
							<div class="control-group">
								<label class="control-label">Ngày bắt đầu</label>
								<div class="controls">
									<input type="text" class="span12" value="${task.startDate }" id="start_date" name="start_date">
								</div>
							</div>
							<div class="control-group">
							<div class="control-group">
								<label class="control-label">Ngày kết thúc</label>
								<div class="controls">
									<input type="text" class="span12" value="${task.endDate }" id="end_date" name="end_date">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tên Jobs</label>
								<div class="controls row-fluid">
									<select class="span12 chzn-select" name="job_id"
										id="job_id" data-placeholder="Chọn Job"
										tabindex="1">
										<c:forEach items="${jobs}" var="item">
											<option value="${item.id}" ${ item.id == task.id ? "selected" : "" }>${item.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Trạng thái</label>
								<div class="controls row-fluid">
									<select class="span12 chzn-select" name="status_id"
										id="status_id" data-placeholder="Chọn trạng thái" tabindex="1">
										<c:forEach items="${status}" var="item">
											<option value="${item.id}" ${ item.id == task.id ? "selected" : "" }>${item.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="span12">
							<button class="btn btn-success">
								<i class="icon-ok icon-white"></i> Lưu lại
							</button>
							<a href='<c:url value="/project" />' class="btn btn-secondary">
								<i class="icon-ban-circle icon-white"></i> Quay lại
							</a>
						</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- END EXAMPLE TABLE widget-->
	</div>
</div>
		</div>
	</div>
</div>

<!-- END ADVANCED TABLE widget-->
</body>
</html>