import { footer as Footer } from '../../components/index';

let Login = {
    render: async () => {
        let view = `
            <h1>Here is Login page :)</h1>
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

export default Login;