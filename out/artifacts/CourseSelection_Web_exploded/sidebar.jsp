<%--
  Created by IntelliJ IDEA.
  User: 星痕
  Date: 2025/7/5
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- partial -->
<div class="container-fluid page-body-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
            <li class="nav-item ${pageContext.request.requestURI.endsWith('index.jsp') ? 'active' : ''}">
                <a class="nav-link" href="index.jsp">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">首页</span>
                </a>
            </li>
            <!-- 学生菜单 - 仅当用户类型为student时显示 -->

            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#student-menu" aria-controls="student-menu">
                    <i class="mdi mdi-content-paste menu-icon"></i>
                    <span class="menu-title">学生课程管理</span>
                    <i class="menu-arrow"></i>
                </a>
                <div class="collapse" id="student-menu">
                    <ul class="nav flex-column sub-menu">
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('/student/courseSchedule.jsp') ? 'active' : ''}">
                            <a class="nav-link  ${sessionScope.userType == 'teacher' ? 'disabled' : ''}" href="/ClassCourseServlet?action=loading&year=2025&semester=1&week=1">班级课表</a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('/student/courseSelection.jsp') ? 'active' : ''}">
                            <a class="nav-link  ${sessionScope.userType == 'teacher' ? 'disabled' : ''}" href="/CourseSelectionServlet?action=loading&dayOfWeek=0&startTime=0&year=2025&semester=1&title=null">选课</a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('/student/scheduleView.jsp') ? 'active' : ''}">
                            <a class="nav-link  ${sessionScope.userType == 'teacher' ? 'disabled' : ''}" href="/StudentCourseServlet?action=loading&year=2025&semester=1&week=1">我的课表</a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('/student/exams.jsp') ? 'active' : ''}">
                            <a class="nav-link  ${sessionScope.userType == 'teacher' ? 'disabled' : ''}" href="/StudentExamServlet?action=loading&year=2025">我的考试</a>
                        </li>
                    </ul>
                </div>
            </li>


            <!-- 教师菜单 - 仅当用户类型为teacher时显示 -->
            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#teacher-menu" aria-controls="teacher-menu">
                    <i class="mdi mdi-content-save menu-icon"></i>
                    <span class="menu-title">教师课程管理</span>
                    <i class="menu-arrow"></i>
                </a>
                <div class="collapse" id="teacher-menu">
                    <ul class="nav flex-column sub-menu">

                        <li class="nav-item ${pageContext.request.requestURI.endsWith('/teacher/scheduleView.jsp') ? 'active' : ''} ">
                            <a class="nav-link ${sessionScope.userType == 'student' ? 'disabled' : ''}" href="/TeacherCourseServlet?action=loading&year=2025&semester=1&week=1">我的课表</a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('/teacher/addCourse.jsp') ? 'active' : ''} ">
                            <a class="nav-link ${sessionScope.userType == 'student' ? 'disabled' : ''}" href="/AddCourseServlet?action=loading&title=null">添加课程</a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('/teacher/setCourse.jsp') ? 'active' : ''} ">
                            <a class="nav-link ${sessionScope.userType == 'student' ? 'disabled' : ''}" href="/SetCourseServlet?action=loading&year=2025">课程评分</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="nav-item ${pageContext.request.requestURI.contains('/user.jsp') ? 'active' : ''}">
                <a class="nav-link" href="/UserServlet?action=loading">
                    <i class="mdi mdi-account menu-icon"></i>
                    <span class="menu-title">个人信息</span>
                </a>
            </li>

<%--            <li class="nav-item ${pageContext.request.requestURI.contains('forms') ? 'active' : ''}">--%>
<%--                <a class="nav-link" href="pages/forms/basic_elements.html">--%>
<%--                    <i class="mdi mdi-view-headline menu-icon"></i>--%>
<%--                    <span class="menu-title">Form elements</span>--%>
<%--                </a>--%>
<%--            </li>--%>

<%--            <li class="nav-item ${pageContext.request.requestURI.contains('charts') ? 'active' : ''}">--%>
<%--                <a class="nav-link" href="pages/charts/chartjs.html">--%>
<%--                    <i class="mdi mdi-chart-pie menu-icon"></i>--%>
<%--                    <span class="menu-title">Charts</span>--%>
<%--                </a>--%>
<%--            </li>--%>

<%--            <li class="nav-item ${pageContext.request.requestURI.contains('tables') ? 'active' : ''}">--%>
<%--                <a class="nav-link" href="pages/tables/basic-table.html">--%>
<%--                    <i class="mdi mdi-grid-large menu-icon"></i>--%>
<%--                    <span class="menu-title">Tables</span>--%>
<%--                </a>--%>
<%--            </li>--%>

<%--            <li class="nav-item ${pageContext.request.requestURI.contains('icons') ? 'active' : ''}">--%>
<%--                <a class="nav-link" href="pages/icons/mdi.html">--%>
<%--                    <i class="mdi mdi-emoticon menu-icon"></i>--%>
<%--                    <span class="menu-title">Icons</span>--%>
<%--                </a>--%>
<%--            </li>--%>

<%--            <li class="nav-item ${pageContext.request.requestURI.contains('samples') ? 'active' : ''}">--%>
<%--                <a class="nav-link" data-toggle="collapse" href="#auth"--%>
<%--                   aria-expanded="${pageContext.request.requestURI.contains('samples')}"--%>
<%--                   aria-controls="auth">--%>
<%--                    <i class="mdi mdi-account menu-icon"></i>--%>
<%--                    <span class="menu-title">User Pages</span>--%>
<%--                    <i class="menu-arrow"></i>--%>
<%--                </a>--%>
<%--                <div class="collapse ${pageContext.request.requestURI.contains('samples') ? 'show' : ''}" id="auth">--%>
<%--                    <ul class="nav flex-column sub-menu">--%>
<%--                        <li class="nav-item ${pageContext.request.requestURI.endsWith('login.html') ? 'active' : ''}">--%>
<%--                            <a class="nav-link" href="pages/samples/login.html"> Login </a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item ${pageContext.request.requestURI.endsWith('login-2.html') ? 'active' : ''}">--%>
<%--                            <a class="nav-link" href="pages/samples/login-2.html"> Login 2 </a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item ${pageContext.request.requestURI.endsWith('register.html') ? 'active' : ''}">--%>
<%--                            <a class="nav-link" href="pages/samples/register.html"> Register </a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item ${pageContext.request.requestURI.endsWith('register-2.html') ? 'active' : ''}">--%>
<%--                            <a class="nav-link" href="pages/samples/register-2.html"> Register 2 </a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item ${pageContext.request.requestURI.endsWith('lock-screen.html') ? 'active' : ''}">--%>
<%--                            <a class="nav-link" href="pages/samples/lock-screen.html"> Lockscreen </a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--            </li>--%>

<%--            <li class="nav-item ${pageContext.request.requestURI.contains('documentation') ? 'active' : ''}">--%>
<%--                <a class="nav-link" href="documentation/documentation.html">--%>
<%--                    <i class="mdi mdi-file-document-box-outline menu-icon"></i>--%>
<%--                    <span class="menu-title">Documentation</span>--%>
<%--                </a>--%>
<%--            </li>--%>
        </ul>
    </nav>