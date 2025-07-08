
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@include file="navbar.jsp"%>
<%@include file="sidebar.jsp"%>

<!-- partial -->
<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-md-12 grid-margin">
                <div class="d-flex justify-content-between flex-wrap">
                    <div class="d-flex align-items-end flex-wrap">
                        <div class="mr-md-3 mr-xl-5">
                            <h2>课程管理</h2>
                            <p class="mb-md-0">Welcome back</p>
                        </div>
                        <div class="d-flex">
                            <i class="mdi mdi-home text-muted hover-cursor"></i>
                            <p class="text-muted mb-0 hover-cursor">&nbsp;/&nbsp;Dashboard&nbsp;/&nbsp;</p>
                            <p class="text-primary mb-0 hover-cursor">Analytics</p>
                        </div>
                    </div>
                    <div class="d-flex justify-content-between align-items-end flex-wrap">
                        <button type="button" class="btn btn-light bg-white btn-icon mr-3 d-none d-md-block ">
                            <i class="mdi mdi-download text-muted"></i>
                        </button>
                        <button type="button" class="btn btn-light bg-white btn-icon mr-3 mt-2 mt-xl-0">
                            <i class="mdi mdi-clock-outline text-muted"></i>
                        </button>
                        <button type="button" class="btn btn-light bg-white btn-icon mr-3 mt-2 mt-xl-0">
                            <i class="mdi mdi-plus text-muted"></i>
                        </button>
                        <button class="btn btn-primary mt-2 mt-xl-0">Download report</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body dashboard-tabs p-0">
                        <ul class="nav nav-tabs px-4" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="overview-tab" data-toggle="tab" href="#overview" role="tab" aria-controls="overview" aria-selected="true">Students</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="sales-tab" data-toggle="tab" href="#sales" role="tab" aria-controls="sales" aria-selected="false">Teacher</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="purchases-tab" data-toggle="tab" href="#purchases" role="tab" aria-controls="purchases" aria-selected="false">Total</a>
                            </li>
                        </ul>
                        <div class="tab-content py-0 px-0">
                            <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview-tab">
                                <div class="d-flex flex-wrap justify-content-xl-between">
                                    <div class="d-none d-xl-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-calendar-heart icon-lg mr-3 text-primary"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">日期</small>
                                            <div class="dropdown">
                                                <a class="btn btn-secondary dropdown-toggle p-0 bg-transparent border-0 text-dark shadow-none font-weight-medium" href="#" role="button" id="dropdownMenuLinkA" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <h5 class="mb-0 d-inline-block">26 Jul 2025</h5>
                                                </a>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuLinkA">
                                                    <a class="dropdown-item" href="#">12 Aug 2025</a>
                                                    <a class="dropdown-item" href="#">22 Sep 2025</a>
                                                    <a class="dropdown-item" href="#">21 Oct 2025</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-star-filled mr-3 icon-lg text-danger"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">学生选课人数</small>
                                            <h5 class="mr-2 mb-0">345</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Students views</small>
                                            <h5 class="mr-2 mb-0">550</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-download mr-3 icon-lg text-warning"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Downloads</small>
                                            <h5 class="mr-2 mb-0">83</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Flagged</small>
                                            <h5 class="mr-2 mb-0">243</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="sales" role="tabpanel" aria-labelledby="sales-tab">
                                <div class="d-flex flex-wrap justify-content-xl-between">
                                    <div class="d-none d-xl-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-calendar-heart icon-lg mr-3 text-primary"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">日期</small>
                                            <div class="dropdown">
                                                <a class="btn btn-secondary dropdown-toggle p-0 bg-transparent border-0 text-dark shadow-none font-weight-medium" href="#" role="button" id="dropdownMenuLinkA" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <h5 class="mb-0 d-inline-block">26 Jul 2025</h5>
                                                </a>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuLinkA">
                                                    <a class="dropdown-item" href="#">12 Aug 2025</a>
                                                    <a class="dropdown-item" href="#">22 Sep 2025</a>
                                                    <a class="dropdown-item" href="#">21 Oct 2025</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-download mr-3 icon-lg text-warning"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Downloads</small>
                                            <h5 class="mr-2 mb-0">83</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Teacher views</small>
                                            <h5 class="mr-2 mb-0">150</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-star-filled mr-3 icon-lg text-danger"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">教师授课数</small>
                                            <h5 class="mr-2 mb-0">45</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Flagged</small>
                                            <h5 class="mr-2 mb-0">843</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="purchases" role="tabpanel" aria-labelledby="purchases-tab">
                                <div class="d-flex flex-wrap justify-content-xl-between">
                                    <div class="d-none d-xl-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-calendar-heart icon-lg mr-3 text-primary"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Start date</small>
                                            <div class="dropdown">
                                                <a class="btn btn-secondary dropdown-toggle p-0 bg-transparent border-0 text-dark shadow-none font-weight-medium" href="#" role="button" id="dropdownMenuLinkA" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <h5 class="mb-0 d-inline-block">26 Jul 2018</h5>
                                                </a>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuLinkA">
                                                    <a class="dropdown-item" href="#">12 Aug 2018</a>
                                                    <a class="dropdown-item" href="#">22 Sep 2018</a>
                                                    <a class="dropdown-item" href="#">21 Oct 2018</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-currency-usd mr-3 icon-lg text-danger"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Revenue</small>
                                            <h5 class="mr-2 mb-0">577545</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Total views</small>
                                            <h5 class="mr-2 mb-0">9833550</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-download mr-3 icon-lg text-warning"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Downloads</small>
                                            <h5 class="mr-2 mb-0">2233783</h5>
                                        </div>
                                    </div>
                                    <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                                        <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                                        <div class="d-flex flex-column justify-content-around">
                                            <small class="mb-1 text-muted">Flagged</small>
                                            <h5 class="mr-2 mb-0">3497843</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-7 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <p class="card-title">The three hottest side courses</p>
                        <p class="mb-4">热门课程选课人数变化</p>
                        <div id="cash-deposits-chart-legend" class="d-flex justify-content-center pt-3"></div>
                        <canvas id="cash-deposits-chart"></canvas>
                    </div>
                </div>
            </div>
            <div class="col-md-5 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <p class="card-title">Total number</p>
                        <h1> 28835</h1>
                        <h4>Gross students over the years</h4>
                        <p class="text-muted">在这里，你可以根据自己的培养方案规划学习路径，通过筛选学分、上课时间等条件精准锁定目标课程，一键完成选课操作 </p>
                        <div id="total-sales-chart-legend"></div>
                    </div>
                    <canvas id="total-sales-chart"></canvas>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 stretch-card">
                <div class="card">
                    <div class="card-body">
                        <p class="card-title">The hottest teacher</p>
                        <div class="table-responsive">
                            <table id="recent-purchases-listing" class="table">
                                <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Name</th>
                                    <th>Course</th>
                                    <th>Office</th>
                                    <th>Number of likes</th>
                                    <th>Date</th>
                                    <th>Total views</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>no.1</td>
                                    <td>周bo</td>
                                    <td>Web开发</td>
                                    <td>计算机中心</td>
                                    <td>9999</td>
                                    <td>06 Jan 2025</td>
                                    <td>2274253</td>
                                </tr>
                                <tr>
                                    <td>no.2</td>
                                    <td>张海</td>
                                    <td>数据库</td>
                                    <td>求是办公室</td>
                                    <td>8888</td>
                                    <td>06 Jan 2025</td>
                                    <td>1274253</td>
                                </tr>
                                <tr>
                                    <td>no.3</td>
                                    <td>马jun</td>
                                    <td>Java</td>
                                    <td>计算机中心</td>
                                    <td>7777</td>
                                    <td>06 Jan 2025</td>
                                    <td>1174353</td>
                                </tr>
                                <tr>
                                    <td>no.4</td>
                                    <td>fx</td>
                                    <td>人工智能</td>
                                    <td>国际中心</td>
                                    <td>6666</td>
                                    <td>06 Jan 2025</td>
                                    <td>1114253</td>
                                </tr>
                                <tr>
                                    <td>no.5</td>
                                    <td>ckf</td>
                                    <td>枪械制造</td>
                                    <td>国际中心</td>
                                    <td>5555</td>
                                    <td>06 Jan 2025</td>
                                    <td>1111111</td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- content-wrapper ends -->
    <!-- partial:partials/_footer.html -->
    <footer class="footer">
        <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © <a target="_blank" href="http://www.mobanwang.com/" title="网页模板">网页模板</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="mdi mdi-heart text-danger"></i></span>
        </div>
    </footer>
    <!-- partial -->

<%@include file="footer.jsp"%>
