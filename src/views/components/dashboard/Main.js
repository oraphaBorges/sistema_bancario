const Main = {
    render: () => {
        let view = `
            <h1>Hello component</h1>
        `;

        return view
    },

    after_render: () => { 
        console.log('teste')
    },
}

export default Main;