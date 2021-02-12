import Nav from './Nav';
import Footer from './Footer';
import DashboardMenu from './DashboardMenu';
import HeaderDash from './HeaderDash';

// Formulários
import FormSignup from './forms/FormSignup';

export const nav = Nav.render();
export const footer = Footer.render();

export const formsignup = FormSignup.render();
export const dashboardMenu = DashboardMenu.render();

//dashboard components
export const dashboardHeader = HeaderDash;