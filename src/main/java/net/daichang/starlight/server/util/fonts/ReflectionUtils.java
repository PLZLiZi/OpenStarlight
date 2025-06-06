package net.daichang.starlight.server.util.fonts;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionUtils {

    public static Object getFieldValue(Object instance, String name) {
        Class<?> c = instance.getClass();
        while (c != null) {
            try {
                Field field;
                try {
                    field = c.getDeclaredField(name);
                } catch (NoSuchFieldException | SecurityException e) {
                    field = c.getField(name);
                }
                field.setAccessible(true);
                return field.get(instance);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                System.err.println("Failed to get field value: " + e.getMessage());
            }
            c = c.getSuperclass();
        }
        return null;
    }

    public static Object getFieldValue(Class<?> clazz,String name) {
        Class<?> c = clazz;
        while (c.getSuperclass() != null) {
            try {
                Field field;
                try {
                    field = c.getDeclaredField(name);
                } catch (NoSuchFieldException | SecurityException e) {
                    field = c.getField(name);
                }
                field.setAccessible(true);
                return field.get(null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
                System.err.println("Failed to get field value: " + e.getMessage());
            }

            c = c.getSuperclass();
        }

        return null;
    }

    public static void setFieldValue(Object instance, String name, Object value) {
        Class<?> c = instance.getClass();
        while (c.getSuperclass() != null) {
            try {
                Field field;
                try {
                    field = c.getDeclaredField(name);
                } catch (NoSuchFieldException | SecurityException e) {
                    field = c.getField(name);
                }
                field.setAccessible(true);
                /*Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);*/
                field.set(instance, value);
            } catch (IllegalAccessException | NoSuchFieldException ignored) {
                ignored.printStackTrace();
                System.err.println("Failed to get field value:");
            }

            c = c.getSuperclass();
        }
    }
    public static void setFieldValue(Class<?> c, String name, Object value) {
        while (c.getSuperclass() != null) {
            try {
                Field field;
                try {
                    field = c.getDeclaredField(name);
                } catch (NoSuchFieldException | SecurityException e) {
                    field = c.getField(name);
                }
                field.setAccessible(true);
                /*Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);*/
                field.set(null, value);
            } catch (IllegalAccessException | NoSuchFieldException ignored) {
                ignored.printStackTrace();
                System.err.println("Failed to get field value: ");
            }

            c = c.getSuperclass();
        }
    }

    public static Object invokeMethod(Object instance, String name, Class<?>[] desc, Object... args) {
        Class<?> c = instance.getClass();
        while (c.getSuperclass() != null) {
            try {
                Method method;
                try {
                    method = c.getDeclaredMethod(name, desc);
                } catch (NoSuchMethodException | SecurityException exception) {
                    method = c.getMethod(name, desc);
                }
                try {
                    method.setAccessible(true);
                }
                catch (Exception e){

                }
                return method.invoke(instance, args);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
            }

            c = c.getSuperclass();
        }
        return null;
    }

    public static Object invokeMethod(Class<?> clazz, String name, Class<?>[] desc, Object... args) {
        Class<?> c = clazz;
        while (c.getSuperclass() != null) {
            try {
                Method method;
                try {
                    method = c.getDeclaredMethod(name, desc);
                } catch (NoSuchMethodException | SecurityException exception) {
                    method = c.getMethod(name, desc);
                }
                method.setAccessible(true);
                return method.invoke(null, args);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
            }

            c = c.getSuperclass();
        }
        return null;
    }


    public static Object invokeMethod(Class<?> clazz, String name) {
        Class<?> c = clazz;
        while (c.getSuperclass() != null) {
            try {
                Method method;
                try {
                    method = c.getDeclaredMethod(name);
                } catch (NoSuchMethodException | SecurityException exception) {
                    method = c.getMethod(name);
                }
                method.setAccessible(true);
                return method.invoke(null);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
            }

            c = c.getSuperclass();
        }
        return null;
    }

    public static Object newInstance(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public static Object newInstance(Class<?> clazz, Class<?>[] desc, Object... args) {
        Class<?> c = clazz;

        while (c != null) {
            try {
                Constructor<?> constructor;
                try {
                    constructor = c.getDeclaredConstructor(desc);
                } catch (NoSuchMethodException | SecurityException exception) {
                    constructor = c.getConstructor(desc);
                }

                return constructor.newInstance(args);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                     InstantiationException e) {
                e.printStackTrace();
            }

            c = c.getSuperclass();
        }
        return null;
    }


    public static boolean isInstanceOf(Object obj, Class<?> cls) {
        return cls.isAssignableFrom(obj.getClass());
    }
}
