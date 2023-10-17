import './style/App.css'
import {BrowserRouter,Routes, Route} from 'react-router-dom'
import Login from './Components/Login/Login';
import Registration from './Components/Registration/Registration';
import RegistrationID from './Components/Registration/RegistrationID';
import ForgetPassword from './Components/ForgotPassword/ForgotPassword';
import ChangePassword from './Components/ForgotPassword/ChangePassword';
import ChangePasswordConf from './Components/ForgotPassword/ChangePasswordConf';
import HomeNav from './Components/Navbar/HomeNav';
import OnboardingNav from './Components/Navbar/OnboardingNav';
import RegistrationNew from './Components/Registration/check';
import ChangePasswordRedirect from './Components/ForgotPassword/ChangePasswordRedirect';
import PurchaseOrderMain from './Components/PurchaseOrder/PurchaseOrderMain';
import ItemDetails from './Components/PurchaseOrder/ItemDetails';
import OrderSummary from './Components/PurchaseOrder/OrderSummary';
import UserMgmtMain from './Components/UserMgmt/UserMgmtMain';
import OrderSummaryNew from './Components/PurchaseOrder/OrderSummaryNew';
import ViewSupplierSite from './Components/UserMgmt/ViewSupplierSite';
import ViewSupplierSite2 from './Components/UserMgmt/ViewSupplierSite2';
import SiteRemoveCnfrm from './Components/UserMgmt/SiteRemoveCnfrm';
import SiteAddCnfrm from './Components/UserMgmt/SiteAddCnfrm';
import SiteUpdateCnfrm from './Components/UserMgmt/SiteUpdateCnfrm';
import Dashboard from './Components/Navbar/Dashboard';

function App() 
{
  return (
    
    // <BrowserRouter>
    //   {/* <Routes> */}
    //     {/* <Route path='/' Component={Login}></Route>
    //     <Route path='/Registration' exact Component={RegistrationNew }></Route>
    //     <Route path='/RegistrationID' exact Component={RegistrationID }></Route>
    //     <Route path='/ForgotPassword' exact Component={ForgetPassword}></Route>
    //     <Route path='/ChangePassword' exact Component={ChangePasswordRedirect }></Route>
    //     <Route path='/ChangePasswordConf' exact Component={ChangePasswordConf }></Route>
    //     <Route path='/HomeNav' exact Component={HomeNav}></Route>
    //     <Route path='/OnboardingNav' exact Component={OnboardingNav}></Route> */}
    //     {/* <PurchaseOrderMain/> */}
    //     {/* <ItemDetails/> */}
    //     <OrderSummary/>
    //   {/* </Routes> */}
    // </BrowserRouter>
    <BrowserRouter>
      <Routes>

        <Route path='/PurchaseOrderMain' Component={PurchaseOrderMain}></Route>
        <Route path='/Registration' exact Component={RegistrationNew }></Route>
        <Route path='/RegistrationID' exact Component={RegistrationID }></Route>
        <Route path='/ForgotPassword' exact Component={ForgetPassword}></Route>
        <Route path='/ChangePassword' exact Component={ChangePasswordRedirect }></Route>
        <Route path='/ChangePasswordConf' exact Component={ChangePasswordConf }></Route>
        <Route path='/HomeNav' exact Component={HomeNav}></Route>
        <Route path='/OnboardingNav' exact Component={OnboardingNav}></Route>
        <Route path='/OrderSummary' exact Component={OrderSummaryNew}></Route>
        <Route path='/ItemDetails' exact Component={ItemDetails}></Route>
        <Route path='/UserMgmtMain' exact Component={UserMgmtMain}></Route>
        <Route path='/ViewSupplierSite' exact Component={ViewSupplierSite}></Route>
        <Route path='/ViewSupplierSite2' exact Component={ViewSupplierSite2}></Route>
        <Route path='/SiteRemoveCnfrm' exact Component={SiteRemoveCnfrm}></Route>
        <Route path='/SiteAddCnfrm' exact component={SiteAddCnfrm}></Route>
        <Route path='/SiteUpdateCnfrm' exact Component={SiteUpdateCnfrm}></Route>
        <Route path='/Dashboard' exact Component={Dashboard}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

