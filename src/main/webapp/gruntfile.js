module.exports = function (grunt) {

    grunt.loadNpmTasks('grunt-sass');
    grunt.loadNpmTasks('grunt-concurrent');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.initConfig({
        sass: {
            build: {
                options: {
                    sourceMap: false,
                    compass: false
                },
                files: [{
                    'style/main.css': 'style/main.scss',				
                }]
            }
        },

        watch: {
			dev:{
                options: {
                    livereload: 1337
                },
                files: [
                    'style/**/*.css',
                    'script/**/*.js',
                    'index.html',
					'template/**/*.html'
                ]
            },
            sass: {
                files: [
                    'style/**/*.scss'
                ],
                tasks: [
                    'sass:build'
                ]
            }
        },

        concurrent: {
            build: {
				tasks: ['sass:build', 'watch:sass', 'watch:dev'],                
                options: {
                    logConcurrentOutput: true
                }
            }
        }
    });

    grunt.registerTask('build', ['concurrent:build'])
};
