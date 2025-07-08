<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="../header.jsp"%>
<%@include file="../navbar.jsp"%>
<%@include file="../sidebar.jsp"%>

<!-- partial -->
<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">

            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${year}年${semester == 1 ? '秋' : '春'}季选课</h4>

                        <p class="card-description">学年度: ${year} 学期: 第${semester}学期</p>
                        <table width="100%" class="table table-striped">
                            <thead>
                            <tr>
                                <th width="20%">课程性质</th>
                                <th width="20%">已获学分</th>
                                <th width="20%">应修总学分</th>
                                <th width="20%">已选</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>专业选修课</td>
                                <td>${studentCredit.CNow}</td>
                                <td>${studentCredit.CNeed}</td>
                                <td>${countElectiveCourse}</td>
                            </tr>
                            </tbody>
                        </table>
                        <form action="/CourseSelectionServlet?action=loading" role="form" method="post">
                            <table width="100%">
                                <tbody>
                                <tr>
                                <td width="20%">
                                    <div class="form-group">
                                        <label>星期</label>
                                        <select class="form-control form-control-lg" name="dayOfWeek">
                                            <option value="0">全部</option>
                                            <option value="1">周一</option>
                                            <option value="2">周二</option>
                                            <option value="3">周三</option>
                                            <option value="4">周四</option>
                                            <option value="5">周五</option>
                                            <option value="6">周六</option>
                                            <option value="7">周日</option>
                                        </select>
                                    </div>
                                </td>
                                    <td width="20%">
                                        <div class="form-group">
                                            <label>节次</label>
                                            <select class="form-control form-control-lg" name="startTime">
                                                <option value="0">全部</option>
                                                <option value="1">第一节-第二节</option>
                                                <option value="2">第三节-第四节</option>
                                                <option value="3">第五节-第六节</option>
                                                <option value="4">第七节-第八节</option>
                                                <option value="5">第九节-第十节</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td width="20%">
                                        <input type="hidden" name="title" value="null">
                                        <input type="hidden" name="semester" value="1">
                                        <input type="hidden" name="year" value="2025">
                                        <input type="submit" value="GO" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <c:choose>
                                <c:when test="${title == 'null'}"><p class="hidden"></p></c:when>
                                <c:when test="${title == 'fail' && title == 'error'}"><p>${msg}</p></c:when>
                            </c:choose>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th width="12.5%">
                                        课程号
                                    </th>
                                    <th width="12.5%">
                                        名称
                                    </th>
                                    <th width="12.5%">
                                        学分
                                    </th>
                                    <th width="12.5%">
                                        教师
                                    </th>
                                    <th width="12.5%">
                                        上课时间
                                    </th>
                                    <th width="12.5%">
                                        备注
                                    </th>
                                    <th width="12.5%">
                                        剩余可选人数
                                    </th>
                                    <th width="12.5%">
                                        加入选课
                                    </th>
                                </tr>
                                <c:forEach var="c" items="${studentCourses}">
                                    <tr>
                                        <td>${c.cno}</td>
                                        <td>${c.CName}</td>
                                        <td>${c.credit}</td>
                                        <td>${c.TName}</td>
                                        <td>
                                        <c:forEach var="css" items="${CourseSchedules}">
                                            <c:if test="${c.dayOfWeek == css.dayOfWeek}">${css.day}</c:if>
                                        </c:forEach>
                                        <c:forEach var="css" items="${CourseSchedules}">
                                            <c:if test="${c.time == css.startTime}">${css.sectionRange}</c:if>
                                        </c:forEach>
                                        </td>
                                        <td>${c.DName}</td>
                                        <td>${c.remainPeople}</td>
                                        <td>${c.flag}
                                            <form action="/CourseSelectionServlet" method="post">
                                                <input type="hidden" name="dayOfWeek" value="${c.dayOfWeek}">
                                                <input type="hidden" name="startTime" value="${c.time}">
                                                <input type="hidden" name="year" value="2025">
                                                <input type="hidden" name="semester" value="1">
                                                <input type="hidden" name="action" value="${c.flag == '未选择' ? 'select' : 'cancel'}">
                                                <input type="hidden" name="cno" value="${c.cno}">
                                                <button type="submit" class="btn btn-sm ${(c.flag == '未选择' && c.remainPeople == 0) ? 'disabled' : '' } ${c.flag == '未选择' ? 'btn-primary' : 'btn-danger'}">
                                                        ${c.flag}
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
    <!-- content-wrapper ends -->
    <!-- partial:../../partials/_footer.html -->
    <footer class="footer">
        <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © <a target="_blank"
                                                                                                       href="http://www.mobanwang.com/" title="网页模板">网页模板</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i
                    class="mdi mdi-heart text-danger"></i></span>
        </div>
    </footer>
    <!-- partial -->
<%@include file="../footer.jsp"%>