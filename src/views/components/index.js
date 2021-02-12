import Nav from './Nav';
import Footer from './Footer';
import DashboardMenu from './DashboardMenu';
import HeaderDash from './dashboard/HeaderDash';
import Main from './dashboard/Main';
import Card from './Card';


// Formulários
import FormSignup from './forms/FormSignup';

export const nav = Nav.render();
export const footer = Footer.render();

export const formsignup = FormSignup.render();
export const dashboardMenu = DashboardMenu.render();

//dashboard components
export const card = Card;
export const dashboardHeader = HeaderDash;
export const main = Main;