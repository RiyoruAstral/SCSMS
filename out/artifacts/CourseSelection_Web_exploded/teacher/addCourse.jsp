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

            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">添加课程</h4>
                        <p class="card-description">
                            <c:if test="${title != 'null'}">
                                ${msg}
                            </c:if>

                        </p>
                        <form role="form" action="/AddCourseServlet?action=update" method="post">
                            <div class="form-group">
                                <label for="name">课程名</label>
                                <input type="text" class="form-control" id="name" placeholder="Name" name="name" required="required">
                            </div>
                            <div class="form-group">
                                <label for="location">课程地点</label>
                                <select class="form-control" id="location" name="location">
                                    <c:forEach items="${locations}" var="l">
                                        <option value="${l.dno}">${l.DName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="year">开设学年</label>
                                <select class="form-control" id="year" name="year">
                                    <option value="2025">2025</option>
                                    <option value="2024">2024</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="semester">开设学期</label>
                                <select class="form-control" id="semester" name="semester">
                                    <option value="1">第一学期</option>
                                    <option value="2">第二学期</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="week">课程星期</label>
                                <select class="form-control" id="week" name="week">
                                    <option value="1">星期一</option>
                                    <option value="2">星期二</option>
                                    <option value="3">星期三</option>
                                    <option value="4">星期四</option>
                                    <option value="5">星期五</option>
                                    <option value="6">星期六</option>
                                    <option value="7">星期日</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="time">课程节次</label>
                                <select class="form-control" id="time" name="time">
                                    <option value="1">第一节 - 第二节</option>
                                    <option value="2">第三节 - 第四节</option>
                                    <option value="3">第五节 - 第六节</option>
                                    <option value="4">第七节 - 第八节</option>
                                    <option value="5">第九节 - 第十节</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="startWeek">起始周</label>
                                <select class="form-control" id="startWeek" name="startWeek">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="endWeek">结束周</label>
                                <select class="form-control" id="endWeek" name="endWeek">
                                    <option value="16">16</option>
                                    <option value="15">15</option>
                                    <option value="14">14</option>
                                    <option value="13">13</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="type">课程性质</label>
                                <select class="form-control" id="type" name="type">
                                    <option value="必修">必修</option>
                                    <option value="选修">选修</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="people">容纳人数</label>
                                <select class="form-control" id="people" name="maxPeople">
                                    <option value="10">10</option>
                                    <option value="15">15</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="credit">课程学分</label>
                                <input type="text" class="form-control" id="credit" placeholder="credit" name="credit" value="2">
                            </div>
                            <div class="form-group">
                                <label for="tname">授课人</label>
                                <input type="text" class="form-control" id="tname" value="${tname}" placeholder="${tname}" disabled="disabled">
                                <input type="hidden" class="form-control" name="tname" value="${tname}" placeholder="${tname}">
                            </div>
                            <button type="submit" class="btn btn-primary mr-2">提交</button>
                        </form>
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