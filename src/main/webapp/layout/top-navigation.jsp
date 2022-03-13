<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Header -->

        <div id="header" class="mdk-header bg-dark js-mdk-header m-0" data-fixed data-effects="waterfall">
            <div class="mdk-header__content">
                <div class="navbar navbar-expand-sm navbar-main navbar-dark bg-dark pr-0" id="navbar" data-primary>
                    <div class="container">
                        <!-- Navbar toggler -->

                        <button class="navbar-toggler navbar-toggler-right d-block d-md-none" type="button" data-toggle="sidebar">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <!-- Navbar Brand -->
                        <a href="dashboard.html" class="navbar-brand">
                            <img class="navbar-brand-icon" src="assets/images/logo.png" height="50" alt="Cybersoft" />
                        </a>

                        <span class="mr-3"></span>

                        <form class="search-form d-none d-xl-flex flex mr-3" action="fixed-index.html">
                            <button class="btn" type="submit">
                                <i class="material-icons">search</i>
                            </button>
                            <input type="text" class="form-control" placeholder="Search" />
                        </form>

                        <ul class="nav navbar-nav ml-auto d-none d-md-flex border-left">
                            <li class="nav-item dropdown">
                                <a href="#notifications_menu" class="nav-link dropdown-toggle" data-toggle="dropdown" data-caret="false">
                                    <i class="material-icons nav-icon navbar-notifications-indicator">
                                        notifications_none
                                    </i>
                                </a>
                                <div id="notifications_menu" class="dropdown-menu dropdown-menu-right navbar-notifications-menu">
                                    <div class="dropdown-item d-flex align-items-center py-2">
                                        <span class="flex navbar-notifications-menu__title m-0">
                                            Notifications
                                        </span>
                                        <a href="javascript:void(0)" class="text-muted">
                                            <small>Clear all</small>
                                        </a>
                                    </div>
                                    <div class="navbar-notifications-menu__content" data-perfect-scrollbar>
                                        <div class="py-2">
                                            <div class="dropdown-item d-flex">
                                                <div class="mr-3">
                                                    <div class="avatar avatar-sm" style="width: 32px; height: 32px">
                                                        <img src="assets/images/256_daniel-gaffey-1060698-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle" />
                                                    </div>
                                                </div>
                                                <div class="flex">
                                                    <a href="">Tiáº¿n HoÃ ng</a> ÄÃ£ bÃ¬nh luáº­n trong
                                                    <a href="">Stack</a><br />
                                                    <small class="text-muted">1 phÃºt trÆ°á»c</small>
                                                </div>
                                            </div>
                                            <div class="dropdown-item d-flex">
                                                <div class="mr-3">
                                                    <a href="#">
                                                        <div class="avatar avatar-xs" style="width: 32px; height: 32px">
                                                            <span class="avatar-title bg-purple rounded-circle">
                                                                <i class="material-icons icon-16pt">
                                                                person_add
                                                                </i>
                                                            </span>
                                                        </div>
                                                    </a>
                                                </div>
                                                <div class="flex">
                                                    NgÆ°á»i dÃ¹ng má»i <a href="#">Tráº§n Minh</a> ÄÃ£ ÄÄng kÃ½ tÃ i khoáº£n<br />
                                                    <small class="text-muted">1 giá» trÆ°á»c.</small>
                                                </div>
                                            </div>
                                            <div class="dropdown-item d-flex">
                                                <div class="mr-3">
                                                    <a href="#">
                                                        <div class="avatar avatar-xs" style="width: 32px; height: 32px">
                                                            <span class="avatar-title rounded-circle">JD</span>
                                                        </div>
                                                    </a>
                                                </div>
                                                <div class="flex">
                                                    <a href="#">Máº«n Nhi</a>
                                                    <small class="text-muted">nháº¯n báº¡n:</small><br />
                                                    <div>
                                                        ChÃ o má»i ngÆ°á»i, vui lÃ²ng lÆ°u Ã½ cuá»c háº¹n lÃºc 3 giá» chiá»u
                                                    </div>
                                                    <small class="text-muted">2 phÃºt trÆ°á»c ÄÃ¢y</small>
                                                </div>
                                            </div>

                                            <div class="dropdown-item d-flex">
                                                <div class="mr-3">
                                                    <div class="avatar avatar-sm" style="width: 32px; height: 32px">
                                                        <img src="assets/images/256_daniel-gaffey-1060698-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle" />
                                                    </div>
                                                </div>
                                                <div class="flex">
                                                    <a href="">Tuáº¥n</a> ÄÃ£ bÃ¬nh luáº­n trong
                                                    <a href="">Stack</a><br />
                                                    <small class="text-muted">1 phÃºt trÆ°á»c</small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="javascript:void(0);" class="dropdown-item text-center navbar-notifications-menu__footer">
                                        View All
                                    </a>
                                </div>
                            </li>
                        </ul>

                        <ul class="nav navbar-nav d-none d-sm-flex border-left navbar-border navbar-height align-items-center">
                            <li class="nav-item dropdown">
                                <a href="#account_menu" class="nav-link dropdown-toggle" data-toggle="dropdown" data-caret="false">
                                    <span class="avatar avatar-sm">
                                        <span class="avatar-title rounded-circle bg-warning">
                                            Đạt
                                        </span>
                                    </span>
                                </a>
                                <div id="account_menu" class="dropdown-menu dropdown-menu-right">
                                    <div class="dropdown-item-text dropdown-item-text--lh">
                                        <div><strong>Đạt</strong></div>
                                        <div>@ngotiendat</div>
                                    </div>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item active" href="dashboard.html">
                                        Dashboard
                                    </a>
                                    <a class="dropdown-item" href="profile.html">
                                        My profile
                                    </a>
                                    <a class="dropdown-item" href="account-edit.html">
                                        Edit account
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href='<c:url value="/logout" />'>Logout</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>