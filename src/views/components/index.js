import Nav from './Nav';
import Footer from './Footer';
import Loader from './Loader';
import DashboardMenu from './DashboardMenu';
import HeaderDash from './dashboard/HeaderDash';
import AccountPlan from './dashboard/AccountPlan';
import Transaction from './dashboard/Transaction';
import Extract from './dashboard/Extract';
import Main from './dashboard/Main';

// Formulários
import FormSignup from './forms/FormSignup';

export const nav = Nav.render();
export const footer = Footer.render();
export const loader = Loader.render();

export const formsignup = FormSignup.render();
export const dashboardMenu = DashboardMenu.render();

//dashboard components
export const dashboardHeader = HeaderDash;
export const main = Main;
export const accountPlan = AccountPlan;
export const transaction = Transaction;
export const extract = Extract;